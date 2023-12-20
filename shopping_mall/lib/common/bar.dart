import 'package:flutter/material.dart';
import 'package:get/get.dart';

class Bar {
  static var buttomIcon = Row(
    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
    children: [
      IconButton(
        onPressed: (){
          Get.back();
        }, 
        icon: Icon(Icons.arrow_back)
      ),
      Icon(Icons.accessibility_outlined),
      Icon(Icons.add_alert_rounded)
    ]
  );

  static AppBar topIcon(String title) {
     return AppBar(leading: Icon(Icons.ad_units), title: Text("$title"), backgroundColor: Colors.green);
  }  
}