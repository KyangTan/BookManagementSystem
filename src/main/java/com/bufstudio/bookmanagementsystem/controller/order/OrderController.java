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

    @GetMapping("/{orderId}")
    ResponseEntity<Map<String, Object>> getOrder(@PathVariable Long orderId);

    @GetMapping
    ResponseEntity<Map<String, Object>> getOrderList(@RequestBody GetOrderListRequest request);

    @PostMapping
    ResponseEntity<Map<String, Object>> createNewOrder(@RequestBody CreateOrderRequest request);

    @PutMapping(value = "/{orderId}")
    ResponseEntity<Map<String, Object>> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderRequest request);

    @DeleteMapping(value = "/{orderId}")
    ResponseEntity<Map<String, Object>> deleteOrder(@PathVariable Long orderId);


//    @PostMapping("/applyPromo")
//    public ResponseEntity<Map<String, Object>> applyPromoToOrder(@RequestBody ApplyPromoRequest request);
}
