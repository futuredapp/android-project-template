danger.import_dangerfile(github: "thefuntasty/danger")

# Utils
def report_checkstyle_for_directory(directory_name)
  if Dir.exists?(directory_name)
    Dir.entries(directory_name).select {|f| f.end_with? '.xml'}.each {|f|
      report_checkstyle(directory_name + f)
    }
  end
end

def report_checkstyle(file_name)
  if File.file?(file_name)
    checkstyle_format.report file_name
  end
end

# Setup checkstyle
checkstyle_format.base_path = Dir.pwd

# Detekt checkstyle
report_checkstyle 'build/reports/detekt/detekt.xml'

# Original checkstyle
report_checkstyle 'app/build/reports/checkstyle/checkstyle.xml'

# Ktlint checkstyle
report_checkstyle_for_directory 'app/build/reports/ktlint/'
