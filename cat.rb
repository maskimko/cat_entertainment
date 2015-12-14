#!/usr/bin/env ruby

ARGV.each do |arg|
    puts arg
end

STDIN.read.split("\n").each do |line|
    puts line
end

