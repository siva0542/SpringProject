package com.example.makeMyTrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping("register")
    public String register(UserDetails user){
        System.out.println("Registration process is going on.......");
        if(!(user.getName()==null)){
            userRepository.save(user);
            return "redirect:/login";
        }
        else
        return "register";
    }

    @RequestMapping("login")
    public String login(Login login)
    {
        System.out.println("Login process is going on.....");
       UserDetails userDetails=userRepository.findByLoginAndPassword(login.getUsername(),login.getPassword());
        if(!(login.getUsername()==null)){
            if(userDetails.getName().equalsIgnoreCase(login.getUsername()) && userDetails.getPassword().equalsIgnoreCase(login.getPassword()))
            return "redirect:/travel";
        }
        return "login";
    }


    @RequestMapping("adminLogin")
    public String adminLogin(AdminLogin adminlogin)
    {
        System.out.println(" Admin Login process is going on.....");
        Admin admin=adminRepository.findByLoginAndPassword(adminlogin.getUsername(),adminlogin.getPassword());
        if(!(adminlogin.getUsername()==null)){
            if(adminlogin.getUsername().equalsIgnoreCase(adminlogin.getUsername()) && adminlogin.getPassword().equalsIgnoreCase(adminlogin.getPassword()))
                return "redirect:/adminSource";
        }
        return "adminLogin";
    }

    @RequestMapping("adminSource")
    public String adminSource(Places places){
        System.out.println("Admin added places.......");
        if(!(places.getSource()==null && places.getDestination()==null)){
            placeRepository.save(places);
            return "redirect:/adminLogin";
        }
            return "adminSource";
    }


    @RequestMapping("travel")
    public  String travel(Travel travel){
        System.out.println("travelling page opened successfully....");
        Places places=placeRepository.findBySourceAndDestination(travel.getSource(),travel.getDestination());
        if(!(travel.getSource()==null)){
            if(places.getSource().equalsIgnoreCase(travel.getSource()) && places.getDestination().equalsIgnoreCase(travel.getDestination()))
            return "redirect:/vehicle";
        }
        return "travel";
    }

    @RequestMapping("vehicle")
    public  String vehicle(Vehicle vehicle){
        System.out.println("Vehicle page opened successfully.....");
        return "vehicle";
    }

    @RequestMapping("car")
    public String car(Car car){
        if(!(car.getCar_type()==null))
        {
            return "redirect:/payment";
        }
        else
        return "car";
    }

    @RequestMapping("bus")
    public String bus(Bus bus){
        if(!(bus.getBus_type()==null))
        {
            return "redirect:/payment";
        }
        return "bus";
    }

    @RequestMapping("train")
    public String train(Train train){
        if(!(train.getTrain_type()==null))
        {
            return "redirect:/payment";
        }
        else
        return "train";
    }

    @RequestMapping("payment")
    public String payment(){
        return "payment";
    }

    @RequestMapping("creditCard")
    public String creditCard(CreditCard creditCard){
        UserDetails userDetails=userRepository.findByCard_number(creditCard.getCard_number());
        if(!(creditCard.getCard_number()==null)){
            if(userDetails.getCard_number().equalsIgnoreCase(creditCard.getCard_number()))
            return "redirect:/paymentsuccess";
        }
        return "creditCard";
    }

    @RequestMapping("debitCard")
    public String debitCard(DebitCard debitCard){
        UserDetails userDetails=userRepository.findByCard_number(debitCard.getCard_number());
        if(!(debitCard.getCard_number()==null)){
            if(userDetails.getCard_number().equalsIgnoreCase(debitCard.getCard_number()))
            return "redirect:/paymentsuccess";
            else
                return "redirect:/paymentfailed";
        }
        return "debitCard";
    }

    @RequestMapping("paymentsuccess")
    public String paymentsuccess(){
        return "paymentsuccess";
    }

    @RequestMapping("paymentfailed")
    public String paymentfailed(){
        return "paymentfailed";
    }


}
