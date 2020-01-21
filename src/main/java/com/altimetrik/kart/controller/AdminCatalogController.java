package com.altimetrik.kart.controller;

import com.altimetrik.kart.model.Items;
import com.altimetrik.kart.repository.entity.Item;
import com.altimetrik.kart.service.DiscountService;
import com.altimetrik.kart.service.ItemService;
import com.altimetrik.kart.service.TaxDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/catalog")
@ApiResponses(
    value = {
        @ApiResponse(code = 202, message = "Request has been accepted without any error"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server Error. Contact System administrator")
    })
@Api(value = "The controller provides to perform all the admin related operations.")
public class AdminCatalogController {

  @Autowired
  private ItemService itemService;
  @Autowired
  private DiscountService discountService;
  @Autowired
  private TaxDetailService taxDetailService;


  @ApiOperation(
      value = "",
      nickname = "addItem",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping(value = "/item")
  public ResponseEntity<List<Item>> addItemDetails(HttpServletResponse response,
                                                   @RequestBody Items items) {
    if (items == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    List<Item> list = itemService.addItemDetails(items);
    return new ResponseEntity<>(list, HttpStatus.OK);
  }


  @ApiOperation(
      value = "",
      nickname = "updateItem",
      notes = "",
      response = ResponseEntity.class)
  @PutMapping(value = "/item")
  public ResponseEntity<Item> updateItemDetails(HttpServletResponse response,
                                                @RequestBody Items items) {
    if (items == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
    Item list = itemService.updateItem(items);
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @ApiOperation(
      value = "",
      nickname = "fetchItemDetailsById",
      notes = "",
      response = ResponseEntity.class)
  @GetMapping(value = "/item/{id}")
  public Item fetchItemById(@PathVariable(name = "id") Long id) {
    return itemService.getItemById(id);
  }

  @ApiOperation(
      value = "",
      nickname = "deleteItemDetailsById",
      notes = "",
      response = ResponseEntity.class)
  @DeleteMapping(value = "/item/{id}")
  public String deleteItemById(@PathVariable(name = "id") Long id) {
    itemService.deleteItemById(id);
    return "Item deleted successfully.";
  }

  @ApiOperation(
      value = "",
      nickname = "deleteItemDetailsById",
      notes = "",
      response = ResponseEntity.class)
  @DeleteMapping(value = "/item")
  public String deleteItems() {
    itemService.deleteItems();
    return "All Item deleted successfully.";
  }


  @ApiOperation(
      value = "",
      nickname = "fetchAllItemDetails",
      notes = "",
      response = ResponseEntity.class)
  @GetMapping(value = "/item")
  public ResponseEntity<List<Item>> fetchAllItems() {
    List<Item> list = itemService.getItems();
    return new ResponseEntity<>(list, HttpStatus.OK);
  }
}