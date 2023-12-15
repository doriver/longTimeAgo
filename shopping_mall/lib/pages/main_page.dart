import 'package:flutter/material.dart';
import 'package:shopping_mall/component/product_widget.dart';
import 'package:shopping_mall/models/product.dart';
import 'package:shopping_mall/repositories/product_repository.dart';

class MainPage extends StatelessWidget {
  // const MainPage({super.key});
  final List<Product> products = ProductRepository().getProducts();
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("쇼핑몰"), backgroundColor: Colors.green),
      body: Column(
        children: [
          Row(
            children: [
              ProductWidget(item: products[0]),
              const SizedBox( width: 10 ),
              ProductWidget(item: products[1])
            ]
          ),
          const SizedBox( height: 50 ),
          Row(
            children: [
              ProductWidget(item: products[2]),
              const SizedBox( width: 10 ),
              ProductWidget(item: products[3])
            ]
          ),
          const SizedBox( height: 30 ),
          Text("회원목록")
        ]
      )
    );
  }
}