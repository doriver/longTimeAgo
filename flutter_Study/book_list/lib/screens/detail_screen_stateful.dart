import 'package:book_list/models/book.dart';
import 'package:flutter/material.dart';

class Detail extends StatefulWidget {

  final Book book;
  Detail({required this.book});

  @override
  State<Detail> createState() => _DetailState();
}

class _DetailState extends State<Detail> {

  bool isRed = false;
  
  void toggleIconColor() {
    setState(() {
      isRed = !isRed;
    });
  }

  @override
  Widget build(BuildContext context) {
    // widget 속성을 통해 Book 객체에 접근
    Book currentBook = widget.book;

    MaterialColor? iconColor = isRed ? Colors.red : null; // 빨간색 또는 기본색(null)을 설정
    return Scaffold(
      appBar: AppBar( title: Text(currentBook.title) ),
      body: Column(
        children: [
          Image.network(
              currentBook.image,
              width: 300.0, // 이미지의 너비
              height: 500.0, // 이미지의 높이
              fit: BoxFit.cover, // 이미지가 주어진 너비 및 높이에 맞도록 조절됩니다.
          ),
          SizedBox(height: 15),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    currentBook.title,
                    style: TextStyle( fontSize: 23, fontWeight: FontWeight.bold )
                  ),
                  Text(
                    currentBook.subtitle,
                    style: TextStyle(fontSize: 15, color: Colors.grey)
                  )
                ]
              ),
              IconButton(onPressed: (){ toggleIconColor(); }, icon: Icon(Icons.star, color: iconColor))
            ]
          ),
          SizedBox(height: 15),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.call, color: Colors.blue)),
                  Text('Contact')
                ]
              ),
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.near_me, color: Colors.blue)),
                  Text('Route')
                ]
              ),
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.save, color: Colors.blue)),
                  Text('Save')
                ]
              )
            ]
          ),
          Container(
            padding: EdgeInsets.all(15),
            child: Text(currentBook.description)
          )
        ],
      )
    );
  }
}

