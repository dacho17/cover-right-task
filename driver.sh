# #!/bin/bash

show_script_title() {
	echo ""
	echo "###############################################"
	echo "#         WELCOME TO DRIVER SCRIPT            #"
	echo "###############################################"
}

show_script_shutdown_msg() {
	echo "###############################################"
	echo "#### Shutting down QrCode REST API Driver  ####"
	echo "###############################################"
	echo ""
}

invalid_n_of_args() {
	echo "Invalid number of arguments has been provided. Please run the driver again with exactly one argument."
	echo ""
	show_script_shutdown_msg
	exit 1
}

invalid_arg() {
	echo "Argument $1 does not match either 'app' or 'test' value. Run the driver with one of the formentioned arguments."
	echo ""
	show_script_shutdown_msg
	exit 1
}

########################################
########   START OF THE SCRIPT	########
########################################

show_script_title

if [ $# -ne 1 ]; then
    invalid_n_of_args
fi

# the argument must be either 'prod' or 'stag'
if [ "$1" = "prod" ]
then
	echo $'The app will be run in production mode.\n'
	sleep 2

	./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
elif [ "$1" = "stag" ]
then
	echo $'The app will be run in staging mode.\n'
	sleep 2

	./mvnw spring-boot:run -Dspring-boot.run.profiles=staging
else
    invalid_arg
fi


echo $'The script has finished executing!\n'
show_script_shutdown_msg
exit 0
