package com.media.service.copic.Controllers;


import com.media.service.copic.Service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media/")
public class FireController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/delete")
    public String delete(@RequestHeader String id){
        return firebaseService.deleteImg(id);
    }
}
