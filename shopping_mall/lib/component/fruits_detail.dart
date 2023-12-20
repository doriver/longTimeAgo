import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';
import 'package:shopping_mall/models/product.dart';

class FruitsDetail extends StatefulWidget {
  final Product item;
  const FruitsDetail({super.key, required this.item});

  @override
  State<FruitsDetail> createState() => _FruitsDetailState();
}

class _FruitsDetailState extends State<FruitsDetail> {
  bool isFavoritPressed = false;
    
  @override
  Widget build(BuildContext context) {
    var productName = widget.item.productName.toString();
    var imagePath = widget.item.imagePath.toString();
    var price = widget.item.price.toString();

    return Scaffold(
      appBar: Bar.topIcon('$productName 페이지'),
      body: ListView(
        children: [
          Stack(
            children: [
              Container(
                margin: EdgeInsets.all(10),
                child: Image.asset(imagePath),
                color: Colors.brown[100],
              ),
              Positioned(
                bottom: 20,
                left: 20,
                child: IconButton(
                  onPressed: () {
                    setState(() {
                      isFavoritPressed = !isFavoritPressed;
                    });
                  }, 
                  icon: Icon(
                    size: 30,
                    isFavoritPressed? Icons.favorite : Icons.favorite_border
                  ),
                  color: Colors.redAccent.shade100
                )
              ),
            ]
          ),
          Column(
            children: [
              Text(productName, style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              Text(price)
            ]
          ),
          SizedBox(height: 20)
        ]
      ),
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}