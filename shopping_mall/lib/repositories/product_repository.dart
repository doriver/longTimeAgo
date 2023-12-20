import 'package:shopping_mall/models/product.dart';

class ProductRepository {
  final List<Product> _dummyProducts = [
    Product(
      productName: "수호신",
      imagePath:
          "https://cdn.aitimes.kr/news/photo/202303/27617_41603_044.jpg",
      price: "3,000 원"
    ),
    Product(
      productName: "천국의 계단",
      imagePath: "https://png.pngtree.com/thumb_back/fh260/background/20230316/pngtree-heaven-gate-ladder-background-image_1948845.jpg",
      price: "5,000 원"
    ),
    Product(
      productName: "오리",
      imagePath:
          "https://images.pexels.com/photos/16756656/pexels-photo-16756656.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
      price: "6,000 원"
    ),
    Product(
      productName: "무지개 반도체",
      imagePath:
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmaIWPqzF72_fIIbKDxzHStwbNRGK4K3iO-w&usqp=CAU",
      price: "7,000 원"
    )
  ];

  List<Product> getProducts() {
    return _dummyProducts;
  }

  final List<Product> _fruitList = [
    Product(
      productName: "바나나",
      imagePath: "assets/images/banana.png",
      price: "4,500원",
    ),
    Product(
      productName: "포도",
      imagePath: "assets/images/grape.png",
      price: "12,000원",
    ),
    Product(
      productName: "복숭아",
      imagePath: "assets/images/peach.png",
      price: "8,500원",
    ),
    Product(
      productName: "딸기",
      imagePath: "assets/images/strawberry.png",
      price: "28,500원",
    ),
    Product(
      productName: "수박",
      imagePath: "assets/images/watermelon.png",
      price: "19,000원",
    ),
    Product(
      productName: "오렌지",
      imagePath: "assets/images/orange.png",
      price: "9,000원",
    ),
  ];

  List<Product> getFruits() {
    return _fruitList;
  }
}