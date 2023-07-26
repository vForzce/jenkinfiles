pipeline {
  agent any
  parameters {
      string(name: 'file_name', defaultValue: 'NetworkTestTool.py', description: 'Input your Python script file name')
      string(name: 'directory', defaultValue: 'ThousandEyesNetworkAutomation/NetworkTest/Script', description: 'Input the directory name of your Python script file')
  }
  stages {
    stage('Run Python Script') {
      steps {
         echo "${directory}/${file_name}"
         sh '''#!/bin/bash
              cd ${directory}
              source /var/jenkins_home/venv/extreme/bin/activate
	      python -u ${file_name} create --type tcp --auto
              python -u ${file_name} create --type icmp --auto
              deactivate'''
      }
    }

  }
}