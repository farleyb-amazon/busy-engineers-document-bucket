# Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

bootstrap:
	@echo "Bootstrapping Python environment..."
	@# Cloud9 sets an alias in bashrc
	@sed -i'.ori' -e 's/alias python.*//' ~/.bashrc
	@echo "==========================================================================="
	@echo "Setting up environment for Python..."
	@echo "==========================================================================="
	curl https://pyenv.run | $$SHELL
	@echo "==========================================================================="
	@echo "Got pyenv..."
	@echo "==========================================================================="
	@# https://github.com/pyenv/pyenv/wiki/Common-build-problems
	@# Python compile requirements
	sudo yum install -y @development zlib-devel bzip2 bzip2-devel readline-devel sqlite \
		 sqlite-devel openssl-devel xz xz-devel libffi-devel findutils
	@echo "==========================================================================="
	@echo "Got dependencies..."
	@echo "==========================================================================="
	@# pyenv environment variables
	echo 'export PATH="/home/ec2-user/.pyenv/bin:$$PATH"' >> ~/.bashrc
	echo 'eval "$$(pyenv init -)"' >> ~/.bashrc
	echo 'eval "$$(pyenv virtualenv-init -)"' >> ~/.bashrc
	. ~/.bashrc
	@echo "==========================================================================="
	@echo "Set environment variables..."
	@echo "==========================================================================="
	@echo "Starting Python install..."
	@echo "==========================================================================="
	PATH="/home/ec2-user/.pyenv/bin:$$PATH" pyenv install 3.8.0
	PATH="/home/ec2-user/.pyenv/bin:$$PATH" pyenv global 3.8.0
	@# No, really, don't use system pip :(
	~/.pyenv/shims/python -m pip install --upgrade pip
	~/.pyenv/shims/python -m pip install tox
	@echo "==========================================================================="
	@echo "Python install complete."
	@echo "Please close this terminal window and open a new one to pick up changes"
	@echo "==========================================================================="

remove:
	rm -rf /home/ec2-user/.pyenv
