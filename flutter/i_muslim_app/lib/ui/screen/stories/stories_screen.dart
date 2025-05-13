import 'package:flutter/material.dart';
import 'package:i_muslim_app/models/Stoies.dart';
import 'package:i_muslim_app/ui/screen/stories/stories_type_screen.dart';
import 'package:i_muslim_app/ui/widget/custom_app_bar_widget.dart';
import 'package:i_muslim_app/ui/widget/custom_item_list_widget.dart';

import '../../../network/api_service.dart';
import '../../widget/custom_loading_widget.dart';

class StoriesScreen extends StatefulWidget {
  const StoriesScreen({super.key});

  @override
  State<StoriesScreen> createState() => _StoriesScreenState();
}

class _StoriesScreenState extends State<StoriesScreen> {
  bool isLoading = true;
  List<Stories> _stories = [];

  void loadData() async {
    setState(() => isLoading = true);
    final data = await ApiService().fetchStoriesData();
    setState(() {
      _stories = data;
      isLoading = false;
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
      appBar: CustomAppBar(title: 'Stories'),
      body:
          isLoading
              ? const LoadingWidget()
              : ListView.builder(
                itemCount: _stories.length,
                itemBuilder: (context, index) {
                  return CustomItemListWidget(
                    title: _stories[index].title,
                    action: () {
                      Navigator.of(context).push(
                        MaterialPageRoute(
                          builder:
                              (context) => StoriesTypeScreen(title: _stories[index].title, story: _stories[index].stories),
                        ),
                      );
                    },
                  );
                },
              ),
    );
  }
}
