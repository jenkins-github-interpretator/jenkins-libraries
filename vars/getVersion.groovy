def call(versionKey = 'SemVer') {

  def version = readFile file: 'version.txt'

  echo "Version: ${version}"

  return "${version}"
}