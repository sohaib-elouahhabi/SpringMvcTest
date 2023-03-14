package com.example.SpringMvcTest.controllers;

import com.example.SpringMvcTest.DAO.ImpProduitDao;
import com.example.SpringMvcTest.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    ImpProduitDao impproduitdao;

    /* It provides list of employees in model object */


    @GetMapping("/")
    public String indexx()
    {
        return "redirect:/produits";
    }

    @GetMapping("/produits")
    public String index(Model m){
        List<Produit> list=impproduitdao.getProduits();
        m.addAttribute("listProduits",list);
        return "produit";
    }


    @GetMapping("/produits/add")
    public String showform(Model m){
        m.addAttribute("command", new Produit());
        return "form";
    }
    @PostMapping("/produits/add")
    public String save(@ModelAttribute("p") Produit p){
        impproduitdao.save(p);
        return "redirect:/produits";
    }

    @RequestMapping("/produits/delete/{code}")
    public String delete(@PathVariable int code){
        impproduitdao.delete(code);
        return "redirect:/produits";
    }

    @RequestMapping(value="/produits/edit/{code}")
    public String showupdateform(@PathVariable int code, Model m){
        Produit p=impproduitdao.getProduitById(code);
//        System.out.println(p.getId()+p.getDesignation());
        m.addAttribute("command",p);
        return "updateform";
    }
    /* It updates model object. */
    @PostMapping(value="/produits/edit/{code}")
    public String update(@ModelAttribute("p") Produit p){
        impproduitdao.edit(p);
        return "redirect:/produits";
    }

}
