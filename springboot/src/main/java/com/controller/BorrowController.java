package com.controller;


import com.common.Result;
import com.controller.request.BorrowPageRequest;
import com.entity.Borrow;
import com.entity.Retur;
import com.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    IBorrowService borrowService;

    @PostMapping("/save")
    public Result save(@RequestBody Borrow obj) {
        borrowService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Borrow obj) {
        borrowService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        borrowService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Borrow obj = borrowService.getById(id);
        return Result.success(obj);
    }

    @GetMapping("/list")
    public Result list() {
        List<Borrow> list = borrowService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(BorrowPageRequest pageRequest) {
        return Result.success(borrowService.page(pageRequest));
    }

    @GetMapping("/pageRetur")
    public Result pageRetur(BorrowPageRequest pageRequest) {
        return Result.success(borrowService.pageRetur(pageRequest));
    }

    @PostMapping("/saveRetur")
    public Result saveRetur(@RequestBody Retur obj) {
        borrowService.saveRetur(obj);
        return Result.success();
    }

    @DeleteMapping("/deleteRetur/{id}")
    public Result deleteRetur(@PathVariable Integer id) {
        borrowService.deleteReturById(id);
        return Result.success();
    }

    //  timeRange: week month month2 month3
    @GetMapping("/lineCharts/{timeRange}")
    public Result lineCharts(@PathVariable String timeRange) {
        return Result.success(borrowService.getCountByTimeRange(timeRange));
    }

}
