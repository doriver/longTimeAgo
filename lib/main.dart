import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar( backgroundColor: Colors.blue, title: Text('My Flutter App') ),
        body:  
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('My Flutter App'),
              Text('안녕'),
              Icon(Icons.star),
              Icon(Icons.star),
            ]
          ),
        bottomNavigationBar: 
          BottomAppBar( 
            color: Colors.white, 
            height: 60.0,
            child: 
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Icon(Icons.phone),
                  Icon(Icons.message),
                  Icon(Icons.contact_page)
                ]
              ),
          ),
      )
    );
  }
}