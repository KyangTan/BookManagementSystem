package com.bufstudio.bookmanagementsystem.service.analysis;

import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopEarningBookDto;
import com.bufstudio.bookmanagementsystem.model.dto.analysis.TopSellingBookDto;
import com.bufstudio.bookmanagementsystem.model.entity.Order;
import com.bufstudio.bookmanagementsystem.model.entity.OrderedBook;
import com.bufstudio.bookmanagementsystem.repository.order.OrderRepository;
import com.bufstudio.bookmanagementsystem.repository.ordered_book.OrderedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    OrderedBookRepository orderedBookRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<TopSellingBookDto> generateTopSellingBooksReport(Integer topN) {
        List<OrderedBook> allOrderedBooks = getAllOrderedBooks();

        HashMap<OrderedBook, BigDecimal> orderedBookEarningMap = new HashMap<>();
        HashMap<OrderedBook, Integer> orderedBookCountMap = new HashMap<>();

        allOrderedBooks.forEach(a -> {
            // Update the earnings map
            orderedBookEarningMap.put(
                    a,
                    orderedBookEarningMap.getOrDefault(a, BigDecimal.ZERO).add(a.getBook().getPrice())
            );

            // Update the count map
            orderedBookCountMap.put(
                    a,
                    orderedBookCountMap.getOrDefault(a, 0) + a.getQuantity()
            );
        });

        List<TopSellingBookDto> topSellingBookDtos = orderedBookCountMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .map(entry -> {
                    TopSellingBookDto dto = new TopSellingBookDto();
                    dto.setBookName(entry.getKey().getBook().getTitle());
                    dto.setCount(entry.getValue());
                    dto.setTotalEarning(orderedBookEarningMap.get(entry.getKey()));
                    return dto;
                })
                .toList();

        return topSellingBookDtos;
    }

    @Override
    public List<TopEarningBookDto> generateTopEarningBooksReport(Integer topN) {
        List<OrderedBook> allOrderedBooks = getAllOrderedBooks();

        HashMap<OrderedBook, BigDecimal> orderedBookEarningMap = new HashMap<>();
        HashMap<OrderedBook, Integer> orderedBookCountMap = new HashMap<>();

        allOrderedBooks.forEach(a -> {
            // Update the earnings map
            orderedBookEarningMap.put(
                    a,
                    orderedBookEarningMap.getOrDefault(a, BigDecimal.ZERO).add(a.getBook().getPrice())
            );

            // Update the count map
            orderedBookCountMap.put(
                    a,
                    orderedBookCountMap.getOrDefault(a, 0) + a.getQuantity()
            );
        });

        List<TopEarningBookDto> topEarningBookDtos = orderedBookEarningMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .map(entry -> {
                    TopEarningBookDto dto = new TopEarningBookDto();
                    dto.setBookName(entry.getKey().getBook().getTitle());
                    dto.setTotalEarning(entry.getValue());
                    dto.setCount(orderedBookCountMap.get(entry.getKey()));
                    return dto;
                })
                .toList();

        return topEarningBookDtos;
    }

    private List<OrderedBook> getAllOrderedBooks() {
        List<Order> allOrders = orderRepository.findAll().stream()
                .filter(order -> !order.getIsDeleted())
                .toList();

        if (allOrders.isEmpty()) {
            return null;
        }

        List<OrderedBook> allOrderedBooks = allOrders.stream()
                .flatMap(order -> orderedBookRepository.findAllByOrderId(order.getId()).stream())
                .toList();

        if (allOrderedBooks.isEmpty()) {
            return null;
        }

        return allOrderedBooks;
    }
}
