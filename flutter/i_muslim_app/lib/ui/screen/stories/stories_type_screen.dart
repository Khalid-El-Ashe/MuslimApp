import 'package:flutter/material.dart';
import 'package:i_muslim_app/models/Story.dart';
import 'package:i_muslim_app/ui/screen/details_screen.dart';
import 'package:i_muslim_app/ui/widget/custom_app_bar_widget.dart';

import '../../widget/custom_item_list_widget.dart';

class StoriesTypeScreen extends StatefulWidget {
  final String title;
  final List<Story> story;

  const StoriesTypeScreen({
    super.key,
    required this.title,
    required this.story,
  });

  @override
  State<StoriesTypeScreen> createState() => _StoriesTypeScreenState();
}

class _StoriesTypeScreenState extends State<StoriesTypeScreen> {
  // bool isLoading = true;
  List<Story> _stories = [];

  void loadData() async {
    // setState(() => isLoading = true);
    // await Future.delayed(const Duration(seconds: 2));
    setState(() {
      _stories = widget.story;
      // isLoading = false;
    });
  }

  @override
  void initState() {
    super.initState();
    loadData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: CustomAppBar(title: widget.title),
      body: ListView.builder(
                itemCount: _stories.length,
                itemBuilder: (context, index) {
                  return CustomItemListWidget(
                    title: _stories[index].name,
                    action: () {
                      Navigator.of(context).push(
                        MaterialPageRoute(
                          builder:
                              (context) => DetailsScreen(
                                title: _stories[index].name,
                                content: _stories[index].content,
                                youtube_url: _stories[index].youtube_url,
                              ),
                        ),
                      );
                    },
                  );
                },
              ),
    );
  }
}
