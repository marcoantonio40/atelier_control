resource "aws_security_group" "atelier_control_security_group" {
  name = "atelier_control_security_group"
  description = "atelier_control security group"
  vpc_id = aws_vpc.atelier_control_vpc.id
}

resource "aws_security_group_rule" "atelier_control_security_group_rule_out" {
  from_port = 0
  protocol = "-1"
  security_group_id = aws_security_group.atelier_control_security_group.id
  to_port = 0
  type = "egress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "atelier_control_security_group_rule_ssh_in" {
  from_port = 22
  protocol  = "tcp"
  security_group_id = aws_security_group.atelier_control_security_group.id
  to_port = 22
  type = "ingress"
  cidr_blocks = ["0.0.0.0/0"]
}

resource "aws_security_group_rule" "atelier_control_security_group_rule_http_in" {
  type = "ingress"
  from_port = 80
  to_port = 80
  protocol = "tcp"
  cidr_blocks = ["0.0.0.0/0"]
  security_group_id = aws_security_group.atelier_control_security_group.id
}

resource "aws_key_pair" "atelier_control_key" {
  key_name   = "atelier_control_key"
  public_key = file("~/.ssh/atelier_key.pub")
}

