package au.id.jackmatthews.jsonresponse.example.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import au.id.jackmatthews.jsonresponse.JsonMixin;
import au.id.jackmatthews.jsonresponse.JsonResponse;
import au.id.jackmatthews.jsonresponse.example.Address;
import au.id.jackmatthews.jsonresponse.example.Customer;
import au.id.jackmatthews.jsonresponse.example.mixins.AddressMixin;
import au.id.jackmatthews.jsonresponse.example.mixins.CustomerMixin;

import com.google.common.collect.Lists;

@Controller
public class CustomerController {

    List<Customer> data;

    public CustomerController() {
        this.data = Lists.newArrayList(
                new Customer(1, "Jack", "Matthews", "Jacko", new Address(1, "Hoppers Crossing", "Australia")), new Customer(1,
                        "John", "Smith", "Kiwi", new Address(1, "Sheep Town", "New Zealand")));
    }

    @RequestMapping("/customers")
    public @ResponseBody
    List<Customer> list() {
        return this.data;
    }

    @RequestMapping("/customers/summary")
    @JsonResponse(mixins = { @JsonMixin(target = Customer.class, mixin = CustomerMixin.class),
            @JsonMixin(target = Address.class, mixin = AddressMixin.class) })
    public @ResponseBody
    List<Customer> listSummary() {
        return this.data;
    }

    @RequestMapping("/customers/{id}")
    public @ResponseBody
    Customer get(@PathVariable("id") Integer id) {
        return this.data.get(id - 1);
    }

    @RequestMapping("/customers/{id}/summary")
    @JsonResponse(mixins = { @JsonMixin(target = Customer.class, mixin = CustomerMixin.class),
            @JsonMixin(target = Address.class, mixin = AddressMixin.class) })
    public @ResponseBody
    Customer getSummary(@PathVariable("id") Integer id) {
        return this.data.get(id - 1);
    }

}
