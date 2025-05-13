import 'package:flutter/material.dart';

import '../../models/ColorSelect.dart';

class CustomAppBar extends StatelessWidget implements PreferredSizeWidget {
  final String title;
  final List<Widget> actions;

  const CustomAppBar({super.key, required this.title, this.actions = const []});

  @override
  Widget build(BuildContext context) {
    return AppBar(
      shape: const RoundedRectangleBorder(
        borderRadius: BorderRadius.only(
          bottomLeft: Radius.circular(20),
          bottomRight: Radius.circular(20),
        ),
      ),
      backgroundColor: ColorSelect.primary,
      title: Text(title, style: TextStyle(color: ColorSelect.white)),
      actions: actions,
    );
  }

  @override
  Size get preferredSize => const Size.fromHeight(60.0);
}
