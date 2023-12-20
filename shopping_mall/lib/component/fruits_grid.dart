import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shopping_mall/component/fruits_detail.dart';
import 'package:shopping_mall/models/product.dart';
import 'package:shopping_mall/repositories/product_repository.dart';

class FruitsGrid extends StatelessWidget {
  // const FruitsGrid({super.key});
  final List<Product> fruitsList = ProductRepository().getFruits();

  static const Color black54 = Colors.black54;

  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        mainAxisSpacing: 10,
        crossAxisSpacing: 10,
        childAspectRatio: 5 / 4
      ),
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
          child: Stack(
            alignment: Alignment.bottomCenter,
            children: [
              Container(
                color: Colors.amber,
                child: Image.asset(imagePath)
              ),
              Positioned(
                top: 10,
                left: 10,
                child: Text(
                  productName,
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)
                )
              ),
              Positioned(
                bottom: 10,
                left: 60,
                child: Text(
                  price,
                  style: TextStyle(color: black54)
                )
              )
            ]
            

          )
        );
      }
    );
  }
}