import 'package:flutter/cupertino.dart';
import 'package:i_muslim_app/models/ColorSelect.dart';
import 'package:loading_animation_widget/loading_animation_widget.dart';

class LoadingWidget extends StatelessWidget {
  const LoadingWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Center(
      child: LoadingAnimationWidget.discreteCircle(
        color: ColorSelect.primary,
        size: 50,
      ),
    );
  }
}
