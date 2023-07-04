package api.cvt.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.cvt.app.model.User;
import api.cvt.app.service.EmployeeService;
import api.cvt.app.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private  UserServiceImpl userService;
    
    public UserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}
	

    @GetMapping("/all")
    public ResponseEntity<List<UserRecord>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable("email") String email){
        return  userService.getUser(email);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        userService.delete(email);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

}
