package com.bufstudio.bookmanagementsystem.controller.order;

import com.bufstudio.bookmanagementsystem.model.request.order.GetOrderListRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.CreateOrderRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.UpdateOrderRequest;
import com.bufstudio.bookmanagementsystem.model.request.order.DeleteOrderRequest;
//import com.bufstudio.bookmanagementsystem.model.request.order.ApplyPromoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/orders")
public interface OrderController {


    @PostMapping
    public ResponseEntity<Map<String, Object>> createNewOrder(@RequestBody CreateOrderRequest request);


    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable Long orderId);


    @PostMapping("/list")
    public ResponseEntity<Map<String, Object>> getOrderList(@RequestBody GetOrderListRequest request);


    @PutMapping
    public ResponseEntity<Map<String, Object>> updateOrder(@RequestBody UpdateOrderRequest request);


    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteOrder(@RequestBody DeleteOrderRequest request);


//    @PostMapping("/applyPromo")
//    public ResponseEntity<Map<String, Object>> applyPromoToOrder(@RequestBody ApplyPromoRequest request);
}
