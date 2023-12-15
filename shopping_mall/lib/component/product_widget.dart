import 'package:flutter/material.dart';
import 'package:shopping_mall/models/product.dart';

class ProductWidget extends StatelessWidget {
  final Product item;
  const ProductWidget({super.key, required this.item});

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: GestureDetector(
        onTap: (){
        },
        child: Column(
          children: [
            AspectRatio(
              aspectRatio: 2/1, 
              child: Image.network( item.imagePath ?? "" )
            ),
            SizedBox(height: 10),
            Text(
              item.productName ?? "",
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)
            ),
            Text(item.price ?? "")
          ]
        )
      )
    );
  }
}