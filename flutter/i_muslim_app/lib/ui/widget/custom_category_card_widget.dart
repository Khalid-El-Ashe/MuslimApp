import 'package:flutter/material.dart';
import 'package:i_muslim_app/models/ColorSelect.dart';

class CategoryCardWidget extends StatelessWidget {
  final String title;
  final String imagePath;
  final VoidCallback? onClick;

  const CategoryCardWidget({
    super.key,
    required this.title,
    required this.imagePath,
    this.onClick,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 150,
      height: 150,
      child: InkWell(
        onTap: onClick,
        child: Card(
          elevation: 3,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
          ),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Expanded(flex: 7, child: Image.asset(imagePath, width: 70, height: 50, fit: BoxFit.fitWidth)),
              Expanded(flex: 3, child: Container(
                alignment: Alignment.center,
                color: ColorSelect.cardTitleBackground,
                child: Text(
                  title,
                  style: TextStyle(color: ColorSelect.primary),
                ),
              ))
            ],
          ),
        ),
      ),
    );
  }
}
