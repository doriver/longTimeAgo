import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:shopping_mall/common/bar.dart';
import 'package:shopping_mall/component/product_widget.dart';
import 'package:shopping_mall/models/product.dart';
import 'package:shopping_mall/pages/member_list_page.dart';
import 'package:shopping_mall/pages/my_page.dart';
import 'package:shopping_mall/pages/product_fruit_page.dart';
import 'package:shopping_mall/pages/store_page_list.dart';
import 'package:shopping_mall/repositories/product_repository.dart';

class MainPage extends StatelessWidget {
  // const MainPage({super.key});
  final List<Product> products = ProductRepository().getProducts();
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon("쇼핑몰"),
      body: ListView(
        children: [
          const SizedBox( height: 30 ),
          Row(
            children: [
              ProductWidget(item: products[0]),
              const SizedBox( width: 10 ),
              ProductWidget(item: products[1])
            ]
          ),
          const SizedBox( height: 20 ),
          Row(
            children: [
              ProductWidget(item: products[2]),
              const SizedBox( width: 10 ),
              ProductWidget(item: products[3])
            ]
          ),
          const SizedBox( height: 40 ),
          ListTile(
            title: Text("회원목록", textAlign: TextAlign.center),
            onTap: (){
              Get.to(() => MemberListPage());
            }
          ),
          ListTile(
            title: Text("매장목록", textAlign: TextAlign.center),
            onTap: (){
              Get.to(() => StoreListPage());
            }
          ),
          ListTile(
            title: Text("마이페이지", textAlign: TextAlign.center),
            onTap: (){
              Get.to(() => MyPage());
            }
          ),
          ListTile(
            title: Text("상품목록", textAlign: TextAlign.center),
            onTap: (){
              Get.to(() => ProductFruitPage());
            }
          ),
          const SizedBox( height: 50 ),
        ]
      ),
      bottomNavigationBar: BottomAppBar(
        child: Bar.buttomIcon
      )
    );
  }
}