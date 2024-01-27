import csv
import glob
import pathlib
import shutil
import subprocess
import os

cardpath = os.path.expanduser("~/Tools/StSCardImagesCreator/cards")
converter = os.path.expanduser("~/Tools/StSCardImagesCreator/StSCardImagesCreator-0.0.5-jar-with-dependencies.jar")
converterpath = os.path.expanduser("~/Tools/StSCardImagesCreator")
imagepath = os.path.expanduser("~/Tools/StSCardImagesCreator/images")

csvfile = open('STSModTable.csv', newline='')
csvreader = csv.reader(csvfile)
next(csvreader)

for row in csvreader:
	if row[1] == '':
		continue

	inputfile = "art/ID_" + row[0] + ".kra";
	if not os.path.isfile(inputfile):
		continue

	outputfile = cardpath + "/ID_" + row[0] + ".png";
	if os.path.isfile(outputfile):
		os.remove(outputfile)

	print('Converting ' + row[1] + '...')
	subprocess.run(["krita", inputfile, "--export", "--export-filename", outputfile], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

for file in glob.glob("art/*.png"):
	shutil.copyfile(file, os.path.expanduser(cardpath) + pathlib.Path(file).name)

subprocess.run(["java", "-jar", converter], cwd = converterpath);

csvfile = open('STSModTable.csv', newline='')
csvreader = csv.reader(csvfile)
next(csvreader)

for file in glob.glob("src/main/resources/TheGuyModResources/images/cards/*.png"):
	if os.path.isfile(file):
		os.remove(file)

for file in glob.glob("src/main/resources/TheGuyModResources/images/ppowers/*.png"):
	if os.path.isfile(file):
		os.remove(file)

for row in csvreader:
	if row[1] == '':
		continue

	inputfile = "art/ID_" + row[0] + ".kra";
	if not os.path.isfile(inputfile):
		continue

	print('Importing ' + row[1] + '...')

	if row[2] == 'Attack':
		shutil.copyfile(imagepath + "/Attacks/ID_" + row[0] + ".png", "src/main/resources/TheGuyModResources/images/cards/ID_" + row[0] + ".png")
		shutil.copyfile(imagepath + "/Attacks/ID_" + row[0] + "_p.png", "src/main/resources/TheGuyModResources/images/powers/ID_" + row[0] + "_p.png")

	if row[2] == 'Power':
		shutil.copyfile(imagepath + "/Powers/ID_" + row[0] + ".png", "src/main/resources/TheGuyModResources/images/cards/ID_" + row[0] + ".png")
		shutil.copyfile(imagepath + "/Powers/ID_" + row[0] + "_p.png", "src/main/resources/TheGuyModResources/images/powers/ID_" + row[0] + "_p.png")

	if row[2] == 'Skill':
		shutil.copyfile(imagepath + "/Skills/ID_" + row[0] + ".png", "src/main/resources/TheGuyModResources/images/cards/ID_" + row[0] + ".png")
		shutil.copyfile(imagepath + "/Skills/ID_" + row[0] + "_p.png", "src/main/resources/TheGuyModResources/images/powers/ID_" + row[0] + "_p.png")
