sealed class Result<T> {
  const Result();

  bool get isLoading => this is Loading<T>;

  bool get isSuccess => this is Success<T>;

  bool get isFailed => this is Failed<T>;

  T? get data => this is Success<T> ? (this as Success<T>).data : null;

  String? get message => this is Failed<T> ? (this as Failed<T>).message : null;
}

class Loading<T> extends Result<T> {
  const Loading();
}

class Success<T> extends Result<T> {
  final T data;

  const Success(this.data);
}

class Failed<T> extends Result<T> {
  final String message;

  const Failed(this.message);
}