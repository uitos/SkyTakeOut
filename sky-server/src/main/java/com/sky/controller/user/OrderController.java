package com.sky.controller.user;

import com.sky.controller.notify.PayNotifyController;
import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userOrderController")
@RequestMapping("/user/order")
@Slf4j
@Api(tags = "用户端订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 功能描述: 用户下单
     * @param ordersSubmitDTO
     * @return com.sky.result.Result<com.sky.vo.OrderSubmitVO>
     */
    @PostMapping("/submit")
    @ApiOperation("用户下单")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单,参数为：{}",ordersSubmitDTO);
        OrderSubmitVO orderSubmitVO = orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    /**
     * 功能描述: 订单支付
     * @param ordersPaymentDTO
     * @return com.sky.result.Result<OrderPaymentVO>
     */
    @PutMapping("/payment")
    @ApiOperation("订单支付")
    public Result<OrderPaymentVO> payment(@RequestBody OrdersPaymentDTO ordersPaymentDTO) throws Exception {
        log.info("订单支付：{}", ordersPaymentDTO);
        OrderPaymentVO orderPaymentVO = orderService.payment(ordersPaymentDTO);
        log.info("生成预支付交易单：{}", orderPaymentVO);
        //TODO 无商户号不能进行真实支付
        orderService.paySuccess(ordersPaymentDTO.getOrderNumber());
        log.info("订单支付单号：{}", ordersPaymentDTO.getOrderNumber());
        return Result.success(orderPaymentVO);
    }

    /**
     * 功能描述: 历史订单查询
     * @param ordersPageQueryDTO
     * @return com.sky.result.Result<com.sky.result.PageResult>
     */
    @GetMapping("/historyOrders")
    @ApiOperation("历史订单查询")
    public Result<PageResult> page(OrdersPageQueryDTO ordersPageQueryDTO){
        log.info("历史订单查询",ordersPageQueryDTO);
        PageResult pageResult = orderService.pageQueryUser(ordersPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 功能描述: 查询订单详情
     * @param id
     * @return com.sky.result.Result<com.sky.vo.OrderVO>
     */
    @GetMapping("/orderDetail/{id}")
    @ApiOperation("查询订单详情")
    public Result<OrderVO> details(@PathVariable Long id){
        log.info("查询订单详情,{}",id);
        OrderVO orderVO = orderService.details(id);
        return Result.success(orderVO);
    }

    /**
     * 功能描述: 取消订单
     * @param id
     * @return com.sky.result.Result
     */
    @PutMapping("/cancel/{id}")
    @ApiOperation("取消订单")
    public Result cancel(@PathVariable Long id) throws Exception {
        orderService.userCancelById(id);
        return Result.success();
    }
}
