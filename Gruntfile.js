module.exports = function (grunt) {
    // Project configuration.
    grunt.file.defaultEncoding = 'utf8';
    grunt.file.preserveBOM = true;
    grunt.option("timestamp", (new Date()).valueOf().toString());

    grunt.initConfig({
            pkg: grunt.file.readJSON('package.json'),
            exec: {
                options: {
                    stdout: true,
                    stderr: true
                },
                run_selenium_hub: {
                    command: "java -jar src/main/resources/selenium-hub/selenium-server-standalone-3.8.1.jar -port 4444 -role hub"
                },
                run_selenium_node: {
                    command: 'java -jar src/main/resources/selenium-hub/selenium-server-standalone-3.8.1.jar -role node -port 5555 -hub http://localhost:4444/grid/register'
                }
            },
            wait: {
                pause: {
                    options: {
                        delay: 10000
                    }
                }
            },
            concurrent: {
                prod: {
                    tasks: ['exec:run_selenium_hub', 'exec:run_selenium_node'], options: {
                        logConcurrentOutput: true
                    }
                }
            },
            clean: {
                all: ['build/reports/tests']
            }
        }
    );

    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-exec');
    grunt.loadNpmTasks('grunt-concurrent');
    grunt.loadNpmTasks('grunt-wait');

    // To run task just write in terminal: grunt <task_name> --force
    grunt.registerTask('clean_and_run', ['clean:all', 'concurrent:prod']);
};