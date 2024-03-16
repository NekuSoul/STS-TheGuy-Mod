import glob
import pathlib
import shutil
import subprocess
import os


for file in glob.glob("art/relics/*.kra"):
	outputfile = "src/main/resources/TheGuyModResources/images/relics/" + pathlib.Path(file).stem + ".png";
	print('Converting ' + file + '...')
	subprocess.run(["krita", file, "--export", "--export-filename", outputfile], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
