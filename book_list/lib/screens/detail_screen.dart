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
          Row(
            children: [
              Text(
                book.title,
                style: TextStyle( fontSize: 23, fontWeight: FontWeight.bold )
              ),
              Icon(
                Icons.star,
                color: Colors.red
              )
            ]
          ),
          Row(
            children: [
              Text(
                book.subtitle,
                style: TextStyle(fontSize: 18, color: Colors.grey)
              )
            ]
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Column(
                children: [
                  Icon(Icons.call),
                  Text('Contact')
                ]
              ),
              Column(
                children: [
                  Icon(Icons.near_me),
                  Text('Route')
                ]
              ),
              Column(
                children: [
                  Icon(Icons.save),
                  Text('Save')
                ]
              )
            ]
          ),
          Text(
            book.description
          )
        ],
      )
    );
  }
}