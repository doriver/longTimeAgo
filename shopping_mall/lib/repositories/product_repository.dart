import 'package:shopping_mall/models/product.dart';

class ProductRepository {
  final List<Product> _dummyProducts = [
    Product(
      productName: "의자",
      imagePath:
          "https://m.comfpro.co.kr/web/product/medium/202111/ab99bbc3f5c49160158c29d07ce660bf.jpg",
      price: "3,000 원"
    ),
    Product(
      productName: "냉장고",
      imagePath: "https://t1.daumcdn.net/cfile/tistory/99E36F345E9E595031",
      price: "5,000 원"
    ),
    Product(
      productName: "자동차",
      imagePath:
          "https://img.hankyung.com/photo/202203/0ad0cd5a2df34e36cd91fd08dcbb46c2.jpg",
      price: "6,000 원"
    ),
    Product(
      productName: "에어컨",
      imagePath:
          "https://reviewpro.co.kr/wp-content/uploads/2020/08/%EC%97%90%EC%96%B4%EC%BB%A8%EB%A9%94%EC%9D%B8.jpg",
      price: "7,000 원"
    )
  ];

  List<Product> getProducts() {
    return _dummyProducts;
  }
}