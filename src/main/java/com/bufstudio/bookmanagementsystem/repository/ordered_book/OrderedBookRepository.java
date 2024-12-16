package com.bufstudio.bookmanagementsystem.repository.ordered_book;

import com.bufstudio.bookmanagementsystem.model.entity.OrderedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedBookRepository extends JpaRepository<OrderedBook, Long>, JpaSpecificationExecutor<OrderedBook> {
    List<OrderedBook> findAllByOrderId(Long orderId);
}
