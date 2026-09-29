package lk.tech.nikita15.controller;

import lk.tech.nikita15.dto.NewPartieRequest;
import lk.tech.nikita15.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @DeleteMapping("/admin/parties/{id}")
    public void deletePartie(@PathVariable Integer id) {
        adminService.deletePartie(id);
    }

    @PostMapping("/admin/parties")
    public void addPartie(@RequestBody NewPartieRequest request) {
        adminService.addPartie(request);
    }
    @PutMapping("/admin/parties/{id}/{newName}")
    public void updatePartie(@PathVariable Integer id, @PathVariable String newName) {
        adminService.renamePartie(id, newName);
    }
}
