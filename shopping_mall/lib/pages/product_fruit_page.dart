import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';
import 'package:shopping_mall/component/fruits_grid.dart';
import 'package:shopping_mall/component/fruits_list.dart';
import 'package:shopping_mall/component/view_change_button.dart';

class ProductFruitPage extends StatefulWidget {
  const ProductFruitPage({super.key});

  @override
  State<ProductFruitPage> createState() => _ProductFruitPageState();
}

class _ProductFruitPageState extends State<ProductFruitPage> {
  String viewStyle = 'grid';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('상품(과일)들'),
      body: Column(
        children: [
          ViewChangeButton(
            click: (value) {
              setState(() {
                viewStyle = value;
              });
            }
          ),
          Expanded(
            child: viewStyle == 'grid' ? FruitsGrid() : FruitsList()
          )
        ]
      ),
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}