import 'package:book_list/models/book.dart';
import 'package:flutter/material.dart';

class DetailScreen extends StatelessWidget {
  final Book book;
  DetailScreen({required this.book});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar( title: Text(book.title) ),
      body: Column(
        children: [
          Image.network(
              book.image,
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
                    book.title,
                    style: TextStyle( fontSize: 23, fontWeight: FontWeight.bold )
                  ),
                  Text(
                    book.subtitle,
                    style: TextStyle(fontSize: 15, color: Colors.grey)
                  )
                ]
              ),
              IconButton(onPressed: (){}, icon: Icon(Icons.star, color: Colors.red))
            ]
          ),
          SizedBox(height: 15),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.call)),
                  Text('Contact')
                ]
              ),
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.near_me)),
                  Text('Route')
                ]
              ),
              Column(
                children: [
                  IconButton(onPressed: (){}, icon: Icon(Icons.save)),
                  Text('Save')
                ]
              )
            ]
          ),
          Container(
            padding: EdgeInsets.all(15),
            child: Text(book.description)
          )
        ],
      )
    );
  }
}