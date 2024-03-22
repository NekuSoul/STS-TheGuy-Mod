import glob
import pathlib
import shutil
import subprocess
import os


for file in glob.glob("art/powers/*.kra"):
	outputfile84 = "src/main/resources/TheGuyModResources/images/powers/" + pathlib.Path(file).stem + "84.png";
	outputfile32 = "src/main/resources/TheGuyModResources/images/powers/" + pathlib.Path(file).stem + "32.png";
	print('Converting ' + file + '...')
	subprocess.run(["krita", file, "--export", "--export-filename", outputfile84], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
	subprocess.run(["convert", "-resize", "32x32", outputfile84, outputfile32], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
