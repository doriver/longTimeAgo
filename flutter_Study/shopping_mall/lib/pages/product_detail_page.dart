import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';

class ProductDetailPage extends StatelessWidget {
  final String productName;
  final String imagePath;
  final String price;

  const ProductDetailPage({
    super.key, 
    required this.productName, 
    required this.imagePath, 
    required this.price});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('$productName 상세페이지'),
      drawer: Bar.drawer(),
      body: SingleChildScrollView(
        child: 
          Container(
            width: double.infinity,
            padding: EdgeInsets.all(50),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Image.network(
                  imagePath,
                  width: 500.0, // 이미지의 너비
                  height: 500.0, // 이미지의 높이
                  fit: BoxFit.cover, // 이미지가 주어진 너비 및 높이에 맞도록 조절됩니다.
                ),
                const SizedBox(height: 30),
                Text(
                  productName,
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 10),
                Text(price),
                const SizedBox(height: 20),
                Text(
                  '구매자 목록',
                  style: TextStyle(fontWeight: FontWeight.bold)
                ),
                Text('김xx, 이xx, 박xx')
              ]
            ),
          )
      ),
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}