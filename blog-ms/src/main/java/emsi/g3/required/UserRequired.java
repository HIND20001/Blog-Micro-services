package emsi.g3.required;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name ="CLIENT" ,url = "http://localhost:8090/")
public interface UserRequired {
    @GetMapping
    public List<userVO> findAll();
    @GetMapping("/{id}")
    public Optional<userVO>findById(@PathVariable Long id);

    @PostMapping
    public int save(@RequestBody userVO user);

    @PutMapping("/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody userVO user);

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable Long id); }




