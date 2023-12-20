import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';
import 'package:shopping_mall/component/view_change_button.dart';

class ProductFruitPage extends StatefulWidget {
  const ProductFruitPage({super.key});

  @override
  State<ProductFruitPage> createState() => _ProductFruitPageState();
}

class _ProductFruitPageState extends State<ProductFruitPage> {
  bool isTogglePressed = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('상품(과일)들'),
      body: Column(
        children: [
          Text('그리드뷰, 리스트뷰'),
          ViewChangeButton(
            onToggle: () {

            }
          ),
          Expanded(
            child: isTogglePressed ? Text('그리드뷰') : Text('리스트뷰')
          )
        ]
      ),
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}