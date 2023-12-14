import 'package:flutter/material.dart';

class ColumnRow extends StatelessWidget {
  const ColumnRow({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10)),
          Container(height: 50,width: 50, color:Colors.blue, margin: EdgeInsets.all(10))
        ]
      )
    );
  }
}