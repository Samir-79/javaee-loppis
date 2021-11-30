package com.widebrain.friends.controller;

import com.widebrain.friends.model.Friend;
import com.widebrain.friends.service.FriendService;
import com.widebrain.friends.util.ErrorMessage;
import com.widebrain.friends.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/friend")
    public
//    Friend create(@RequestBody Friend friend) throws ValidationException {
//        if (friend.getId() == 0 && friend.getFirstName() != null && friend.getLastName() != null)
    Friend create(@Valid @RequestBody Friend friend) {
        return friendService.save(friend);
        //  else throw new ValidationException("friend can not be created");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

        return fieldErrorMessages;
    }
  /*  @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> exceptionHandler(ValidationException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }*/

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    ErrorMessage exceptionHandler(ValidationException e) {
          return new ErrorMessage("400", e.getMessage());
    }*/

    @GetMapping("/friend")
    public Iterable<Friend> read() {
        return friendService.findAll();
    }

    @PutMapping("/friend")
//    Friend update(@RequestBody Friend friend) {
//        return friendService.save(friend);
    ResponseEntity<Friend> update(@RequestBody Friend friend) {
        if (friendService.findById(friend.getId()).isPresent())
            return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/friend/{id}")
    public void delete(@PathVariable Integer id) {
        friendService.deleteById(id);
    }

    @GetMapping("/friend/{id}")
    Optional<Friend> findById(@PathVariable Integer id) {
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(
            @RequestParam(value = "first", required = false) String firstName, @RequestParam(value = "last", required = false) String lastName) {
        if (firstName != null && lastName != null)
            return friendService.findByFirstNameAndLastName(firstName, lastName);
        else if (firstName != null)
            return friendService.findByFirstName(firstName);
        else if (lastName != null)
            return friendService.findByLastName(lastName);
        else
            return friendService.findAll();

    }


}
