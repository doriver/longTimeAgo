import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shopping_mall/component/fruits_detail.dart';
import 'package:shopping_mall/models/product.dart';
import 'package:shopping_mall/repositories/product_repository.dart';

class FruitsList extends StatelessWidget {
  // const FruitsList({super.key});
  final List<Product> fruitsList = ProductRepository().getFruits();

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      padding: EdgeInsets.all(10),
      itemCount: fruitsList.length,
      itemBuilder: (context, index) {
        var productName = fruitsList[index].productName.toString();
        var imagePath = fruitsList[index].imagePath.toString();
        var price = fruitsList[index].price.toString();

        return InkWell(
          onTap: () {
            Get.to(() => FruitsDetail(item: fruitsList[index]));
          },
          child: Container(
            margin: EdgeInsets.all(10),
            height: 150,
            color: Colors.blue[100],
            child: Row(
              children: [
                Image.asset(imagePath),
                SizedBox(width: 10),
                Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(
                      productName,
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                    ),
                    Text(price)
                  ]
                )
              ]
            ),
          )
        );
      });
  }
}