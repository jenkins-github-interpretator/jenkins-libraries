def call() {
    return env.JOB_NAME.tokenize('/').last()
}
