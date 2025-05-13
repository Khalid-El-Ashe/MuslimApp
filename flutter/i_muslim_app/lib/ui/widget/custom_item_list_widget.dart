import 'package:flutter/material.dart';

class CustomItemListWidget extends StatelessWidget {
  final String title;

  // final List<Story> story;
  final Function action;

  const CustomItemListWidget({
    super.key,
    required this.title,
    // this.story = const [],
    required this.action,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: double.infinity,
      height: 100,
      child: InkWell(
        onTap: () {
          action();

          // Navigator.of(context).push(
          //   MaterialPageRoute(
          //     builder:
          //         (context) => StoriesTypeScreen(title: title, story: story),
          //   ),
          // );
        },
        child: Card(
          elevation: 3,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(16),
          ),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Expanded(
                flex: 2,
                child: Container(
                  padding: EdgeInsets.only(left: 10),
                  alignment: Alignment.centerLeft,
                  child: const Icon(Icons.arrow_back_ios, size: 20),
                ),
              ),
              Expanded(
                flex: 8,
                child: Container(
                  padding: const EdgeInsets.all(10),
                  child: Text(
                    title,
                    textAlign: TextAlign.right,
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
