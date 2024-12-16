package com.bufstudio.bookmanagementsystem.repository.user;

import com.bufstudio.bookmanagementsystem.model.entity.OrderedBook;
import com.bufstudio.bookmanagementsystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<OrderedBook> {
}
