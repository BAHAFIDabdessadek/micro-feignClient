package org.example.dgs;

import com.netflix.graphql.dgs.*;
import lombok.RequiredArgsConstructor;
import org.example.model.UserDto;
import org.example.model.User;
import org.example.repo.UserRepo;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@DgsComponent
public class UserDGS {

   // private final UserRepo userRepo;

      private final List<Sinks.Many<User>> sinks = new ArrayList<>();

  //  private final Sinks.Many<User> sinks = Sinks.many().multicast().onBackpressureBuffer();

    /*
    @DgsQuery
    public User getUser(@InputArgument String id) {
        return userRepo.findById(Long.parseLong(id) ).orElseThrow(
                ()-> new RuntimeException("Sorry, we can't found any user with id you entered."));
    }

     */

    @DgsMutation
    public User addUser(@InputArgument("userDto") UserDto userDto){
        User user = User.builder()
                        .id(userDto.getId())
                        .name(userDto.getName())
                        .age(userDto.getAge()).build();
        //User savedUser = userRepo.save(user);
       // sinks.tryEmitNext(savedUser);
        sinks.forEach(sink -> sink.tryEmitNext(user));
        return user;
    }

    @DgsSubscription
    public Publisher<User> userAdded() {
        Sinks.Many<User> sink = Sinks.many().multicast().onBackpressureBuffer();
        sinks.add(sink);
        return sink.asFlux();
    }

}
